class SnakeGame {
        LinkedList<int[]> snake;
        int[][] food;
        int width;
        int height;
        int foodIdx;
        /** Initialize your data structure here.
         @param width - screen width
         @param height - screen height
         @param food - A list of food positions
         E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
        public SnakeGame(int width, int height, int[][] food) {
            this.food = food;
            this.width = width;
            this.height = height;
            this.foodIdx = 0;
            snake = new LinkedList<int[]>();
            snake.addFirst(new int[]{0,0});
        }

        /** Moves the snake.
         @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
         @return The game's score after the move. Return -1 if game over.
         Game over when snake crosses the screen boundary or bites its body. */
        public int move(String direction) {
            int[] head = snake.getFirst();
            int[] nextMove = new int[]{head[0], head[1]};
            switch (direction){
                case  "U":
                    nextMove[0]--;
                    break;
                case "L":
                    nextMove[1]--;
                    break;
                case "R":
                    nextMove[1]++;
                    break;
                case "D":
                    nextMove[0]++;
                    break;
            }
            if(nextMove[0] < 0 || nextMove[0] >= height || nextMove[1] < 0 || nextMove[1] >= width ) return -1;
            int[] tail = snake.getLast();
            snake.removeLast();
            if(isDead(nextMove[0], nextMove[1])) return -1;
            snake.addFirst(nextMove);
            if(food.length > foodIdx && nextMove[0] == food[foodIdx][0]
                    && nextMove[1] == food[foodIdx][1] ){
                foodIdx++;
                snake.add(tail);
                return foodIdx;
            }
            return foodIdx;
        }

        public boolean isDead(int x, int y){
            for (int i = snake.size()-1; i >= 0 ; i--) {
                if(x == snake.get(i)[0] && y == snake.get(i)[1]){
                    return true;
                }
            }
            return false;
        }
    }

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */