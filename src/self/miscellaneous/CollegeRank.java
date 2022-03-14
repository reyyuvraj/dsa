package self.miscellaneous;

import java.util.*;

public class CollegeRank {

    static class Student {
        int id;
        float percentage;
        int choice1;
        int choice2;
        int choice3;

        Student(int id, float percentage, int choice1, int choice2, int choice3) {
            this.id = id;
            this.percentage = percentage;
            this.choice1 = choice1;
            this.choice2 = choice2;
            this.choice3 = choice3;
        }

        int getId(){
            return id;
        }

        float getPercentage() {
            return percentage;
        }

        int getChoice1() {
            return choice1;
        }

        int getChoice2() {
            return choice2;
        }

        int getChoice3() {
            return choice3;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int c = in.nextInt();//Integer.parseInt(in.next());
        int n = in.nextInt();//Integer.parseInt(in.next());
        HashMap<Integer, Boolean> hm = new HashMap<>();

        /*String s = in.nextLine();
        String[] seats = s.split(" ");*/
        int[] seats = new int[c];
        for (int i = 0; i < c; i++)
            seats[i] = in.nextInt();

        ArrayList<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String str = in.next();
            String[] details = str.split(",");
            int v, x, y, z;
            float w;
            v = Integer.parseInt(details[0].substring(details[0].indexOf('-') + 1));
            w = Float.parseFloat(details[1]);
            x = Integer.parseInt(details[2].substring(details[2].indexOf('-') + 1));
            y = Integer.parseInt(details[3].substring(details[3].indexOf('-') + 1));
            z = Integer.parseInt(details[4].substring(details[4].indexOf('-') + 1));
            Student student = new Student(v, w, x, y, z);
            hm.put(v, false);
            students.add(student);
        }

        /*for (Student it : students) {
            System.out.println(it.percentage + "  " + it.id + "  " + it.choice1);
        }
        System.out.println();

        students.sort(((o1, o2)
                -> Float.compare(o2.getPercentage(), o1.getPercentage())));

        //students.sort(t2, t1) -> Float.compare(t2.getDistance, t1.getDistance());

        System.out.println(students);

        for (Student it : students) {
            if (hm.get(it.getChoice1())) {
                hm.put(it.choice1, true);
            } else if (hm.get(it.getChoice2())) {
                hm.put(it.choice2, true);
            } else if (hm.get(it.getChoice3())) {
                hm.put(it.choice3, true);
            }
        }*/

        HashMap<Integer, ArrayList<Integer>> pre = new HashMap<>();
        for (int i = 0; i < c; i++) {
            if (!pre.containsKey(i + 1))
                pre.put(i + 1, new ArrayList<>());
        }

        getPreference(pre, students, n);

        System.out.println(pre);

        HashMap<Integer, ArrayList<Integer>> out = new HashMap<>();
        for (int i = 0; i < c; i++) {
            if (!out.containsKey(i + 1))
                out.put(i + 1, new ArrayList<>());
        }

        HashMap<Integer, Boolean> declared = new HashMap<>();
        for (Student student : students) {
            int id = student.getId();
            if (!declared.containsKey(id))
                declared.put(id, false);
        }
    }

    private static void getPreference(HashMap<Integer, ArrayList<Integer>> pre, ArrayList<Student> students, int n) {
        for (int i = 0; i < students.size(); i++) {
            int c1 = -1, c2 = -1, c3 = -1;
            c1 = students.get(i).getChoice1();
            c2 = students.get(i).getChoice2();
            c3 = students.get(i).getChoice3();
            if (c1 != -1)
                pre.get(c1).add(i);
            if (c2 != -1)
                pre.get(c2).add(i);
            if (c3 != -1)
                pre.get(c3).add(i);
        }
    }

    private static void getStudentsForCollege(HashMap<Integer, ArrayList<Integer>> out, int[] seats, int collegeID, HashMap<Integer, ArrayList<Integer>> pre, ArrayList<Student> students, HashMap<Integer, Boolean> declared) {
        if (seats[collegeID-1]<=0)
            return;

        float max = 0;int index = 0;

        for (int i=0;i<pre.get(collegeID).size();i++){
            int j = pre.get(collegeID).get(i);
            if (students.get(j).getPercentage()>max){
                max = students.get(j).getPercentage();
                index = i;
            }
        }

        pre.get(collegeID).remove(index);
    }
}