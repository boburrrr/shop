package org.example.shop.service;

import lombok.RequiredArgsConstructor;
import org.example.shop.model.card.Card;
import org.example.shop.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;
    public int addCard1(Card card){
        cardRepository.addcard(card);
        return 200;
    }
    public Card getById1(UUID id){
        return cardRepository.getById(id);
    }
    public List<Card> getUserCard1(UUID user_id){
        return cardRepository.getUserCard(user_id);
    }
    public int cardUpdateBalance1(UUID id, Double balance, boolean tree){
        if(cardRepository.cardUpdateBalance(id,balance,tree) == 1){
            return 1;
        }else{
            return -1;
        }
    }
    public Card getByCardNumber1(String card_number){
        return cardRepository.getByCardNumber(card_number);
    }
    public void deleteById(UUID id){
        cardRepository.deleteById(id);
    }
    public void cardUpdatePassword(UUID id, String password){
        cardRepository.cardUpdatePassword(id,password);
    }

}
