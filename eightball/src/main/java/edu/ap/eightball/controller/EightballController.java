package edu.ap.eightball.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import edu.ap.eightball.redis.RedisService;

/**
 * EightballController
 */
@Controller
@Scope("session")
public class EightballController {

    private RedisService service; // pattern : "vragen":vraag:antwoord

    public String[] answers = { "It is certain.", "It is decidedly so.", "Without a doubt.", "Yes - definitely.",
            "You may rely on it.", "As I see it, yes.", "Most likely.", "Outlook good.", "Yes.", "Signs point to yes.",
            "Reply hazy", "try again", "Ask again later.", "Better not tell you now.", "Cannot predict now.",
            "Concentrate and ask again.", "Don't count on it.", "My reply is no.", "My sources say no",
            "Outlook not so good.", "Very doubtful." };

    @Autowired
    public void setRedisService(RedisService service) {
        this.service = service;
    }

    @PostMapping(value="/vraag/{question}")
    public String ask(@PathVariable String question, Model model) {

        List<Integer> numbers = new ArrayList<>();
        String answer = "";
        String pattern = "vragen:" + question + ":*";
        Set<String> keys = service.keys(pattern);
        if(keys.size() == 0)
        {
            Random r = new Random();
            int randomnumber = r.nextInt(answers.length);
            numbers.add(randomnumber);
            while (numbers.contains(randomnumber))
            {
                randomnumber = r.nextInt(answers.length);
            }
            answer = answers[randomnumber];
            service.setKey("vragen:" + question + ":" + answer, "");
            model.addAttribute("answer", answer);
            
        } else
        {
            Set<String> keysfind = service.keys("vragen:*");
            for (String key : keysfind){
                String[] parts = key.split(":");
                if(parts[1].equalsIgnoreCase(question)){
                    answer = parts[2];
                    model.addAttribute("answer", answer);

                }
            }
        }
	  
	   return "answer_result";
    }

}