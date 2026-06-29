package com.example.GrandTickAutoVi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewsExplainerAi {
    private final ChatModel chatModel;

    public String explainer(String news_about,String user_message) {
        String prompt = "Bro Explain me this News what is this about if user ask in any language answer in that language or explain in less than 6 to 7 lines only \n\n"+user_message+"\n\n"+news_about;
        return chatModel.call(prompt);
    }

}
