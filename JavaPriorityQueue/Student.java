public class Student
{
    int id;
    String name;
    double cgpa;

    public Student(int id, String name, double cgpa)
    {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }

    public boolean isPrioritized(Student s)
    {
        if(s.getCGPA() > this.getCGPA())
            return true;
        else if(s.getCGPA() == this.getCGPA() && s.getName() == this.getName())
        {
            if(s.getID() < this.getID())
                return true;

            return false;
        }
        else if(s.getCGPA() == this.getCGPA())
        {
            if(s.getName().compareTo(this.getName()) < 0)
            {
                return true;
            }
        }

        return false;
    }
}
