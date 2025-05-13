public class Stewardess extends Person{
    private int experienceYear;
    private String languages;
    public Stewardess (String name, int age, int experienceYear, String languages) {
        super(name, age);
        this.experienceYear = experienceYear;
        this.languages = languages;
    }
        public String info(){
            String toString=super.info();
            return toString + "\nExperience year: "+experienceYear+"\nKnow languages: "+languages;

        }



    public int getExperienceYear() {
        return experienceYear;
    }

    public void setExperienceYear(int experienceYear) {
        this.experienceYear = experienceYear;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }
}
