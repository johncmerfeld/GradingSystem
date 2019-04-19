package model;

public class Course {
    private int id;
    private String name;
    private String courseSemester;
    private boolean isActive;
    //private ArrayList<Student> students;
    //private ArrayList<Category> categories;
    //private Map<String,Double>  rubric;
    //private ArrayList<Grade> grades;
    public Course(int id, String name, String courseSemester){
        this.id = id;
        this.name = name;
        this.courseSemester = courseSemester;
        this.isActive = true;
        //students = new ArrayList<>();
        //categories = new ArrayList<>();
        //rubric = new HashMap<>();
        //grades = new ArrayList<>();
    }

    public int getCourseId() {
        return id;
    }

    public String getCourseName() {
        return name;
    }

    public String getCourseSemester() {
        return courseSemester;
    }

    public boolean isActive() {
        return isActive;
    }

    public void finishCourse(){
        this.isActive = false;
    }

    public void setActive() {
        isActive = true;
    }

    public void setCourseId(int id) {
        this.id = id;
    }

    public void setCourseName(String name) {
        this.name = name;
    }

    public void setCourseSemester(String courseSemester) {
        this.courseSemester = courseSemester;
    }

    /*
    public ArrayList<Category> getCategories() {
        return categories;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public Map<String, Double> getRubric() {
        return rubric;
    }

    public void addCategory(String name){
        categories.add(new Category(name));
        rubric.put(name,(double)0);
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void addStudent(Student s){
        students.add(s);
        for(int i = 0;i<categories.size();i++){
            for(int j = 0; j<categories.get(i).getGradeItems().size();j++){
                if(categories.get(i).getGradeItems().get(j).getScalingMethod())
                    grades.add(new Grade(categories.get(i).getGradeItems().get(j).getGradItemId(),s.getBUId(),0));
                else
                    grades.add(new Grade(categories.get(i).getGradeItems().get(j).getGradItemId(),s.getBUId(),-1*categories.get(i).getGradeItems().get(j).getMaxPoints()));
            }
        }
    }

    public void removeStudent(int id){
        for(int i = 0; i<grades.size();i++){
            if(grades.get(i).getSid()==id){
                grades.remove(i);
            }
        }
        for(int i = 0; i<students.size();i++){
            if(students.get(i).getBUId() == id){
                students.remove(i);
            }
        }
    }

    public void addGradeItem(String cate, GradeItem gi){
        for(Category c:categories){
            if(c.getCategoryName().equals(cate))
                c.addGradItem(gi);
        }
        for(Student s:students){
            if(gi.getScalingMethod())
                grades.add(new Grade(gi.getGradItemId(),s.getBUId(),0));
            else
                grades.add(new Grade(gi.getGradItemId(),s.getBUId(),-1*gi.getMaxPoints()));
        }

    }

    public void removeGradeItem(String cate, int id){
        for(Category c:categories){
            if(c.getCategoryName().equals(cate))
                c.removeGradItem(id);
        }
        for(Grade g:grades){
            if(g.getGid() == id){
                grades.remove(g);
            }
        }
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }

    public void editGrade(int gid, int sid, double score){
        for(Grade g:grades){
            if(g.getGid() == gid && g.getSid()==sid){
                g.setScore(score);
            }
        }
    }

    */
}
