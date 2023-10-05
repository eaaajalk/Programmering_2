package chattensopgaver;

import java.util.Random;

public class terning {
        private int value;
        private Random random;

        public terning() {
            random = new Random();
            roll();
        }

        public void roll() {
            value = random.nextInt(6) + 1;
        }

        public int getValue() {
            return value;
        }
    }

