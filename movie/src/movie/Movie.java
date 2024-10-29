package movie;


public class Movie {
    private String filmsTitle;
    private String director;
    private int yearOfTheRelease;

    public Movie(String filmsTitle, String director, int yearOfTheRelease) {
        this.filmsTitle = filmsTitle;
        this.director = director;
        this.yearOfTheRelease = yearOfTheRelease;
    }

    public String getFilmsTitle() {
        return filmsTitle;
    }

    public void setFilmsTitle(String filmsTitle) {
        this.filmsTitle = filmsTitle;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYearOfTheRelease() {
        return yearOfTheRelease;
    }

    public void setYearOfTheRelease(int yearOfTheRelease) {
        this.yearOfTheRelease = yearOfTheRelease;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "filmsTitle='" + filmsTitle + '\'' +
                ", director='" + director + '\'' +
                ", yearOfTheRelease=" + yearOfTheRelease +
                '}';
    }
}
