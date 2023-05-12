import java.util.Scanner;

public class Lab_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите параметры проекта");
        System.out.println("Введите плановую деятельность проекта (мес.)");
        double T = scanner.nextDouble();
        System.out.println("Введите плановый бюджет проекта (у.е.)");
        double money = scanner.nextDouble();
        System.out.println();
        System.out.println("Введите данные наблюдений: ");
        System.out.println("Введите время наблюдения (мес.)");
        double time = scanner.nextDouble();
        System.out.println("Введите % исполнения во время наблюдения");
        double s = scanner.nextDouble();
        System.out.println("Введите расходы во время наблюдения: ");
        double r = scanner.nextDouble();

        double timeChange = (time/s-T);
        double moneyChange = (r/money/s-1) * money;
        System.out.println();
        System.out.printf("Изменение продолжительности проекта составило - %.2f \n", timeChange, " месяцев");
        System.out.printf("Изменение бюджета проекта составило - %.2f\n", moneyChange, "у.е.");
    }
}
