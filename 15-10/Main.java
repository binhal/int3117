public class Main {
    public static String giatPTbac2(float a, float b, float c) {
        String output;
        // kiểm tra các hệ số
        if (a == 0) {
            if (b == 0) {
                if (c == 0) output = "Phương trình có vô số nghiệm!";
                else output = "Phương trình vô nghiệm!";
            } else {
                output = "Phương trình có một nghiệm: "
                        + "x = " + (-c / b);
            }
            return output;
        }
        // tính delta
        float delta = b*b - 4*a*c;
        float x1;
        float x2;
        // tính nghiệm
        if (delta > 0) {
            x1 = (float) ((-b + Math.sqrt(delta)) / (2*a));
            x2 = (float) ((-b - Math.sqrt(delta)) / (2*a));
            output = "Phương trình có 2 nghiệm là: "
                    + "x1 = " + x1 + " và x2 = " + x2;
        } else if (delta == 0) {
            x1 = (-b / (2 * a));
            output = "Phương trình có nghiệm kép: "
                    + "x1 = x2 = " + x1;
        } else {
            output = "Phương trình vô nghiệm!";
        }
        return output;
    }

    public static Boolean testFunc(float a, float b, float c, String expectedResult) {
        return giatPTbac2(a, b, c).equals(expectedResult);
    }

    public static void boundaryTest() {
        System.out.println("Kết quả các ca kiểm thử biên: ");
        System.out.println(testFunc(50,50,0, "Phương trình có 2 nghiệm là: x1 = 0.0 và x2 = -1.0"));
        System.out.println(testFunc(50,50,1, "Phương trình có 2 nghiệm là: x1 = -0.020416848 và x2 = -0.97958314"));
        System.out.println(testFunc(50,50,99, "Phương trình vô nghiệm!"));
        System.out.println(testFunc(50,50,100, "Phương trình vô nghiệm!"));
        System.out.println(testFunc(50,0,50, "Phương trình vô nghiệm!"));
        System.out.println(testFunc(50,1,50, "Phương trình vô nghiệm!"));
        System.out.println(testFunc(50,99,50, "Phương trình vô nghiệm!"));
        System.out.println(testFunc(50,100,50, "Phương trình có nghiệm kép: x1 = x2 = -1.0"));
        System.out.println(testFunc(0,50,50, "Phương trình có một nghiệm: x = -1.0"));
        System.out.println(testFunc(1,50,50, "Phương trình có 2 nghiệm là: x1 = -1.0208424 và x2 = -48.979156"));
        System.out.println(testFunc(99,50,50, "Phương trình vô nghiệm!"));
        System.out.println(testFunc(100,50,50, "Phương trình vô nghiệm!"));
        System.out.println(testFunc(50,50,50, "Phương trình vô nghiệm!"));
    }

    public static void decisionTable() {
        System.out.println("Kết quả các ca kiểm thử bằng bảng quyết định:");
        System.out.println(testFunc(0,0,0, "Phương trình có vô số nghiệm!"));
        System.out.println(testFunc(0,0,1, "Phương trình vô nghiệm!"));
        System.out.println(testFunc(0,1,1, "Phương trình có một nghiệm: x = -1.0"));
        System.out.println(testFunc(1,1,1, "Phương trình vô nghiệm!"));
        System.out.println(testFunc(1,2,1, "Phương trình có nghiệm kép: x1 = x2 = -1.0"));
        System.out.println(testFunc(1,4,2, "Phương trình có 2 nghiệm là: x1 = -0.58578646 và x2 = -3.4142137"));
    }

    public static void branchCoverageCriterion() {
        System.out.println("kết quả các ca kiểm thử có độ phủ C2: ");
        System.out.println(testFunc(0,0,0, "Phương trình có vô số nghiệm!"));
        System.out.println(testFunc(0,1,1, "Phương trình có một nghiệm: x = -1.0"));
        System.out.println(testFunc(0,0,1, "Phương trình vô nghiệm!"));
        System.out.println(testFunc(1,1,1, "Phương trình vô nghiệm!"));
        System.out.println(testFunc(1,2,1, "Phương trình có nghiệm kép: x1 = x2 = -1.0"));
        System.out.println(testFunc(1,4,2, "Phương trình có 2 nghiệm là: x1 = -0.58578646 và x2 = -3.4142137"));
    }

    public static void main(String[] args) {
        // kiểm thử biên
        // boundaryTest();
        // kiểm thử bằng bảng quyết định
        // decisionTable();
        // kiểm thử dòng điều khiển độ phủ cấp 2
        branchCoverageCriterion();
    }
}
