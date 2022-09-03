package ru.netology.tournament;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GameTest {

    Game game = new Game();

    Player player1 = new Player(1, "Okee", 500);
    Player player2 = new Player(2, "Moby", 200);
    Player player3 = new Player(3, "Small", 350);
    Player player4 = new Player(4, "Agat", 200);

    @BeforeEach
    public void setup() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
    }

    @Test
    public void shouldWinFirstPlayer() {

        int expected = 1;
        int actual = game.round(player1.getName(), player3.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinSecondPlayer() {

        int expected = 2;
        int actual = game.round(player2.getName(), player3.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeDraw() {

        int expected = 0;
        int actual = game.round(player2.getName(), player4.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void notRegisteredFirstPlayer() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Nick", "Agat");
        });
    }

    @Test
    public void notRegisteredSecondPlayer() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Okee", "Nick");
        });
    }

    @Test
    public void notRegisteredPlayers() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Nick1", "Nick2");
        });
    }
}
