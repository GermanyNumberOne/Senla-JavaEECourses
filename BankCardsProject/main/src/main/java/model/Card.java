package model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Getter
@Setter
@Component
public class Card extends BaseEntity {

    private String number;

    private Short password;

    private Long money;
    @Autowired
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(number, card.number) && Objects.equals(password, card.password) && Objects.equals(money, card.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, password, money);
    }
}
