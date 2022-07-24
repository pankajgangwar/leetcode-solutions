 class FoodRatings {
        HashMap<String, TreeMap<Integer, List<String>>> cuisineMap = new HashMap<>();
        HashMap<String, String> cuisineToFood = new HashMap<>();
        HashMap<String, Integer> foodRatingMap = new HashMap<>();
        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            for (int i = 0; i < foods.length; i++) {
                String food = foods[i];
                String cuisine = cuisines[i];
                int rating = ratings[i];
                foodRatingMap.put(food, rating);
                cuisineToFood.put(food, cuisine);
                cuisineMap.putIfAbsent(cuisine, new TreeMap<>());
                cuisineMap.get(cuisine).putIfAbsent(rating, new ArrayList<>());
                cuisineMap.get(cuisine).get(rating).add(food);
                System.out.println(cuisineMap.get(cuisine).get(rating));
            }
        }

        public void changeRating(String food, int newRating) {
             if(foodRatingMap.containsKey(food)){
                int prevRating = foodRatingMap.get(food);
                foodRatingMap.put(food, newRating);

                String cuisine = cuisineToFood.get(food);
                List<String> list = cuisineMap.get(cuisine).get(prevRating);
                int index = list.indexOf(food);
                list.remove(index);
                if(list.isEmpty()){
                    cuisineMap.get(cuisine).remove(prevRating);
                }
                cuisineMap.get(cuisine).putIfAbsent(newRating, new ArrayList<>());
                cuisineMap.get(cuisine).get(newRating).add(food);
            }
            
        }

        public String highestRated(String cuisine) {
            List<String> list = cuisineMap.get(cuisine).lastEntry().getValue();
            Collections.sort(list);
            return list.get(0);
        }
    }

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */