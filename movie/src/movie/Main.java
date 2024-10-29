package movie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        List<Movie> movies = new ArrayList<>();
        main.addMoviesList(movies);
        main.deleteFromListByDirector(movies,"James Cameron");
        main.updateInfo(movies);
        main.sortMovies(movies);
        System.out.println(movies);

        List<Movie> newMovies = main.filterMovieByDirection(movies,"Christopher Nolan");
        for (Movie movie : newMovies) {
            System.out.println(movie);
        }

    }

    public  void addMoviesList(List<Movie> movies) {
        movies.add(new Movie("Inception", "Christopher Nolan", 2010));
        movies.add(new Movie("The Dark Knight", "Christopher Nolan", 2008));
        movies.add(new Movie("Interstellar", "Christopher Nolan", 2014));
        movies.add(new Movie("Titanic", "James Cameron", 1997));
        movies.add(new Movie("Avatar", "James Cameron", 2009));
        movies.add(new Movie("Fight Club", "David Fincher", 1999));
        movies.add(new Movie("The Social Network", "David Fincher", 2010));
        movies.add(new Movie("The Matrix", "The Wachowskis", 1999));
        movies.add(new Movie("Forrest Gump", "Robert Zemeckis", 1994));
        movies.add(new Movie("The Godfather", "Francis Ford Coppola", 1972));
        movies.add(new Movie("Parasite", "Bong Joon Ho", 2019));
        movies.add(new Movie("Gladiator", "Ridley Scott", 2000));
    }

    public  void deleteFromListByDirector(List<Movie> movies, String direction) {
        //удаление по режиссеру
        Iterator<Movie> iterator = movies.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getDirector().equals(direction)) {
                iterator.remove();
            }
        }
        //  movies.removeIf(director -> director.getDirector().equals("Christopher Nolan"));
    }

    public  void deleteFromListByYear(List<Movie> movies) {
        Iterator<Movie> iterator = movies.iterator();
        //удаление по году выпуска
        while (iterator.hasNext()) {
            if (iterator.next().getYearOfTheRelease() >= 2000) {
                iterator.remove();
            }
        }
        // movies.removeIf(year -> year.getYearOfTheRelease() <= 2000);
    }

    public  void updateInfo(List<Movie> movies) {
        movies.get(5).setFilmsTitle("Robert Polson");
        movies.get(3).setYearOfTheRelease(2000);
        movies.get(movies.size() - 1).setFilmsTitle("Anime");

        System.out.println(movies.get(5));
        System.out.println(movies.get(3));
        System.out.println(movies.get(movies.size() - 1));
    }

    public  void sortMovies(List<Movie> movies) {
        movies.sort(new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o1.getYearOfTheRelease() - o2.getYearOfTheRelease();
            }
        });
    }

    public  List<Movie> filterMovieByDirection(List<Movie> movies,String direction) {
        List<Movie> newMovie = new ArrayList<>();
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getDirector().equals(direction)) {
                newMovie.add(movies.get(i));
            }
        }
        return newMovie;
    }

    public  List<Movie> filterMovieByYear(List<Movie> movies) {
        List<Movie> newMovie = new ArrayList<>();
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getYearOfTheRelease() > 2000) {
                newMovie.add(movies.get(i));
            }
        }
        return newMovie;
    }
}