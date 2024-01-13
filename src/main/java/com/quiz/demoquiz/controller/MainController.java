package com.quiz.demoquiz.controller;

import com.quiz.demoquiz.Answer;
import com.quiz.demoquiz.Quiz;
import com.quiz.demoquiz.dao.ChoiceDao;
import com.quiz.demoquiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.quiz.demoquiz.controller.dto.ChatMessagePrompt;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.service.OpenAiService;

import lombok.var;

@Controller
public class MainController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "");
        return "hello";
    }
    

    @GetMapping("/about")
    public String about() {
        return "about";
    }




        @Autowired
        QuestionService questionService;

        @Autowired
        ChoiceDao choiceDao; // Autowire the ChoiceDao

        @GetMapping("/questions/{id}")
        public String getQuestion(Model model, @PathVariable int id, HttpSession session) {
            List<Quiz> allQuestions = questionService.getAllQuestions();
            if (id >= 0 && id < allQuestions.size()) {
                Quiz currentQuestion = allQuestions.get(id);
                model.addAttribute("question", currentQuestion);
                model.addAttribute("currentIndex", id);
                model.addAttribute("totalQuestions", allQuestions.size());

                if (currentQuestion.isMultipleChoice()) {
                    model.addAttribute("choices", questionService.getChoicesForQuestion(currentQuestion.getId()));
                }
            }
            // Load previous answers from session
            List<Answer> answers = (List<Answer>) session.getAttribute("answers");
            if (answers == null) {
                answers = new ArrayList<>();
                session.setAttribute("answers", answers);
            }

            model.addAttribute("answers", answers); // Send current answers to the view
            return "questions";
        }

        @PostMapping("/questions/{nextId}")
        public String submitAnswerAndGoNext(@PathVariable int nextId, @RequestParam(required = false) Integer selectedChoice, @RequestParam(required = false) String textInput, HttpSession session) {
            List<Answer> answers = (List<Answer>) session.getAttribute("answers");
            if (answers == null) {
                answers = new ArrayList<>();
            }

            Answer answer = new Answer();
            answer.setQuestionId(nextId);

            Quiz currentQuestion = questionService.getQuestionById(nextId); // Assuming you have such a method
            if (currentQuestion.isMultipleChoice() && selectedChoice != null) {
                String choiceText = questionService.getChoiceTextById(currentQuestion.getId(), selectedChoice);
                answer.setUserResponse(choiceText);
            } else if (textInput != null) {
                answer.setUserResponse(textInput);
            }

            answers.add(answer);
            session.setAttribute("answers", answers);

            if (nextId > 20) {
                return "redirect:/summary";
            } else {
                return "redirect:/questions/" + nextId;
            }
        }



        // Method to determine the next question ID or end of the quiz
        private int determineNextQuestionId(int currentId) {
            // Implement your logic here to determine the next question ID
            // For simplicity, this just increments the current ID
            return currentId;
        }

        @GetMapping("/summary")
public String showSummary(Model model, HttpSession session) {
    List<Answer> answers = (List<Answer>) session.getAttribute("answers");
    String prompt = "", result = "",lastLine="";
    if (answers != null) {
        // Construct the prompt, but do not add it to the model
        prompt =  "write   3 destination cities for a trip for people who like " +answers.get(0).getUserResponse()+", "+answers.get(8).getUserResponse()+" , "+answers.get(3).getUserResponse()+", "+
        answers.get(1).getUserResponse()+" locations,"+answers.get(2).getUserResponse()+" trip."+"Budget is "+answers.get(4).getUserResponse()+" euros"+
        " and they plan to travel for "+answers.get(5).getUserResponse()+" days on "+answers.get(10).getUserResponse()+"."+"His travel experience is :"+
        answers.get(7).getUserResponse()+" and he is "+answers.get(9).getUserResponse()+" with language barriers or cultural differences and wants to travell "+answers.get(16).getUserResponse()+". His weather preferences are "+
        answers.get(11).getUserResponse()+" and wants to avoid "+answers.get(12).getUserResponse()+". His health concerns or dietary restrictions are :"+answers.get(13).getUserResponse()+
        ". He is "+answers.get(14).getUserResponse()+" with the current health and safety situation (like political stability, crime rate, pandemic conditions) in potential destinations."+"The interests of the partner are :"+answers.get(17).getUserResponse()+". "+
        "Other specific landmarks, events, or experiences are: "+answers.get(20).getUserResponse()+"     (with three words)-------------------------------                       ";

        OpenAiService service = new OpenAiService("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");
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt(prompt)
                .model("gpt-3.5-turbo-instruct")
                .echo(true)
                .build();
        result = service.createCompletion(completionRequest).getChoices().get(0).getText();

        // Extract and add only the last line of the result to the model
        String[] resultLines = result.split("\\r?\\n");
        lastLine = resultLines[resultLines.length - 1];
        model.addAttribute("lastLine", lastLine);
       
    }else {
        lastLine="Not enough data to find a destination";
        model.addAttribute("lastLine", lastLine);
    }
    // Add other necessary data to the model
     model.addAttribute("answers", answers);
    return "summary"; // summary.html Thymeleaf template
}


	@PostMapping("/chat")
	public String getChatMessages(@RequestBody ChatMessagePrompt prompt) {

		// /v1/chat/completions ->
		// gpt-4, gpt-4-0613, gpt-4-32k, gpt-4-32k-0613, gpt-3.5-turbo,
		// gpt-3.5-turbo-0613, gpt-3.5-turbo-16k, gpt-3.5-turbo-16k-0613

		OpenAiService service = new OpenAiService("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");
		ChatCompletionRequest completionRequest = ChatCompletionRequest.builder().messages(prompt.getChatMessage())
				.model("gpt-3.5-turbo").build();
		return service.createChatCompletion(completionRequest).getChoices().get(0).getMessage().getContent();
	}

    }


