import java.util.ArrayList;
import java.util.HashMap;

class Rating {
    String title;
    String user;
    int rating;

    Rating(String title, String user, int rating) {
        this.title = title;
        this.user = user;
        this.rating = rating;
    }
}

public class MovieRating {
    Rating[] ratings;

    public MovieRating() {
        this.ratings = MovieDB.loadMovieRatings();
    }

    HashMap<String, Double> getAllRatings() {
       // return null; // TODO
        HashMap<String, Double> totalScoreOfEachFilm = new HashMap<>();
        HashMap<String, Integer> totalNumberOfRatings = new HashMap<>();

        //The first loop through the ratings array updates 
        //both hash maps based on the algorithm

        for(Rating r: ratings){
            String movieTitle = r.title;
            //helps update the score
            totalScoreOfEachFilm.put(movieTitle, totalScoreOfEachFilm.getOrDefault(movieTitle, 0.0) + r.rating);
            //helps update the number of ratings!
            // getOrDefault " This method returns value mapped with 
            // the specified key, otherwise default value is returned."
            totalNumberOfRatings.put(movieTitle, totalNumberOfRatings.getOrDefault(movieTitle, 0) + 1);

        }
        HashMap<String, Double> aggregateRatings = new HashMap<>();

        //The second loop calculates the average rating for each 
        //movie and populates the aggregateRatings HashMap.

        for (String title : totalScoreOfEachFilm.keySet()) {

            double totalScore = totalScoreOfEachFilm.get(title);
            int totalRatingsForMovie = totalNumberOfRatings.get(title);

            // we calculate the average rating and add it to the final hash map
            double averageRating = totalScore / totalRatingsForMovie;
            aggregateRatings.put(title, averageRating);
        }
        //hooray return
        return aggregateRatings;

    }

    ArrayList<Rating> getRatingsFor(String title) {
        // return null; // TODO
        ArrayList<Rating> result = new ArrayList<>();
        for (Rating r : ratings) {
            if (r.title.equals(title)) {
                result.add(r);
            }
        }
        return result;
        
    }

    void printAllRatings() {
        HashMap<String, Double> aggregateRatings = getAllRatings();
        for (String title : aggregateRatings.keySet()) {
            System.out.printf("%s: %.1f/10.0\n", title, aggregateRatings.get(title));
        }
    }

    void printRatingsFor(String title) {
        ArrayList<Rating> ratings = getRatingsFor(title);

        /* TODO: If there are no ratings? */
        if(ratings.isEmpty()){
            System.out.println("No ratings found for this movie.");
        } else { 
            //need else statement here btw or else it will run other code,
            // will not automatically exit for some reason that I don't understand 

        System.out.printf("Ratings for %s (Total: %d)\n", title, ratings.size());
        double total = 0;

        for (Rating r : ratings) {
            total += r.rating;
            System.out.printf("%d/10 by %s\n", r.rating, r.user);
        }
        System.out.printf("Average rating: %.1f/10.0\n", (double)total / ratings.size());
        }


    }

    /* TODO: Write the main method */
    public static void main(String[] args){
        MovieRating movies = new MovieRating();

        if (args.length == 1) {
            String movieTitle = args[0];
            movies.printRatingsFor(movieTitle);

        } else {
            // No command line argument
            // print aggregate ratings for all movies
            movies.printAllRatings();
        }
        
    }
    }