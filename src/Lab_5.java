import java.util.Scanner;

public class Lab_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите наиболее вероятную оценку трудозатрат (Mi) для одного экрана");
        double Mi_UIForm = scanner.nextDouble(); // 4
        System.out.println("Укажите наиболее вероятную оценку трудозатрат (Mi) для одного обработчика событий");
        double Mi_Action = scanner.nextDouble(); // 8
        System.out.println("Укажите наиболее вероятную оценку трудозатрат (Mi) для нового бизнес-объекта");
        double Mi_BusinessObject = scanner.nextDouble(); // 3
        System.out.println("Укажите наиболее вероятную оценку трудозатрат (Mi) для добавления нового бизнес-метода");
        double Mi_BusinessMethod = scanner.nextDouble(); // 6
        System.out.println();

        System.out.println("Укажите минимально возможные трудозатраты на реализацию пакета работ (Oi) для одного экрана");
        double Oi_UIForm = scanner.nextDouble(); // 2
        System.out.println("Укажите минимально возможные трудозатраты на реализацию пакета работ (Oi) для одного обработчика событий");
        double Oi_Action = scanner.nextDouble(); // 4
        System.out.println("Укажите минимально возможные трудозатраты на реализацию пакета работ (Oi) для нового бизнес-объекта");
        double Oi_BusinessObject = scanner.nextDouble(); // 2
        System.out.println("Укажите минимально возможные трудозатраты на реализацию пакета работ (Oi) для добавления нового бизнес-метода");
        double Oi_BusinessMethod = scanner.nextDouble(); // 2
        System.out.println();

        System.out.println("Укажите пессимистическую оценку трудозатрат (Pi) для одного экрана");
        double Pi_UIForm = scanner.nextDouble(); // 20
        System.out.println("Укажите пессимистическую оценку трудозатрат (Pi) для одного обработчика событий");
        double Pi_Action = scanner.nextDouble(); // 32
        System.out.println("Укажите пессимистическую оценку трудозатрат (Pi) для нового бизнес-объекта");
        double Pi_BusinessObject = scanner.nextDouble(); // 8
        System.out.println("Укажите пессимистическую оценку трудозатрат (Pi) для добавления нового бизнес-метода");
        double Pi_BusinessMethod = scanner.nextDouble(); // 26
        System.out.println();

        System.out.println("Укажите количество элементов (ед.) для одного экрана");
        double ElementsCount_UIForm = scanner.nextDouble(); // 20
        System.out.println("Укажите количество элементов (ед.) для одного обработчика событий");
        double ElementsCount_Action = scanner.nextDouble(); // 60
        System.out.println("Укажите количество элементов (ед.) для нового бизнес-объекта");
        double ElementsCount_BusinessObject = scanner.nextDouble(); // 16
        System.out.println("Укажите количество элементов (ед.) для добавления нового бизнес-метода");
        double ElementsCount_BusinessMethod = scanner.nextDouble(); // 40
        System.out.println();

        double Ei_UIForm = (Pi_UIForm + 4 * Mi_UIForm + Oi_UIForm) / 6;
        System.out.printf("Оценка средней трудоемкости кодирования (Ei) для одного экрана = %.2f часов\n", Ei_UIForm);
        double Ei_Action = (Pi_Action + 4 * Mi_Action + Oi_Action) / 6;
        System.out.printf("Оценка средней трудоемкости кодирования (Ei) для одного обработчика событий = %.2f часов\n", Ei_Action);
        double Ei_BusinessObject = (Pi_BusinessObject + 4 * Mi_BusinessObject + Oi_BusinessObject) / 6;
        System.out.printf("Оценка средней трудоемкости кодирования (Ei) для нового бизнес-объекта = %.2f часов\n", Ei_BusinessObject);
        double Ei_BusinessMethod = (Pi_BusinessMethod + 4 * Mi_BusinessMethod + Oi_BusinessMethod) / 6;
        System.out.printf("Оценка средней трудоемкости кодирования (Ei) для добавления нового бизнес-метода = %.2f часов\n", Ei_BusinessMethod);
        System.out.println();

        double CKOi_UIForm = (Pi_UIForm - Oi_UIForm) / 6;
        System.out.printf("Среднеквадратическое отклонение (CKOi) для одного экрана = %.2f часов\n", CKOi_UIForm);
        double CKOi_Action = (Pi_Action - Oi_Action) / 6;
        System.out.printf("Среднеквадратическое отклонение (CKOi) для одного обработчика событий = %.2f часов\n", CKOi_Action);
        double CKOi_BusinessObject = (Pi_BusinessObject - Oi_BusinessObject) / 6;
        System.out.printf("Среднеквадратическое отклонение (CKOi) для нового бизнес-объекта = %.2f часов\n", CKOi_BusinessObject);
        double CKOi_BusinessMethod = (Pi_BusinessMethod - Oi_BusinessMethod) / 6;
        System.out.printf("Среднеквадратическое отклонение (CKOi) для добавления нового бизнес-метода = %.2f часов\n", CKOi_BusinessMethod);
        System.out.println();

        double E = ElementsCount_UIForm * Ei_UIForm + ElementsCount_Action * Ei_Action +
                ElementsCount_BusinessObject * Ei_BusinessObject + ElementsCount_BusinessMethod * Ei_BusinessMethod;
        System.out.printf("Суммарная трудоемкость проекта (Е) = %.2f человеко-часов\n", E);

        double CKO = Math.sqrt((ElementsCount_UIForm * Math.pow(CKOi_UIForm, 2) + (ElementsCount_Action * Math.pow(CKOi_Action, 2)) +
                (ElementsCount_BusinessObject * Math.pow(CKOi_BusinessObject, 2)) + (ElementsCount_BusinessMethod * Math.pow(CKOi_BusinessMethod, 2))));
        System.out.printf("Среднеквадратичное отклонение для оценки суммарной трудоемкости кодирования (СКО) = %.2f часов\n", CKO);

        double E95 = E + 2 * CKO;
        System.out.printf("Оценка суммарной трудоемкости кодирования проекта, которую мы не превысим с вероятностью 95 процентов = %.2f человеко-часов\n", E95);

        double RelativeError = (CKO / E) * 100;
        System.out.printf("Относительная погрешность в оценке суммарной трудоемкости = %.2f процентов\n", RelativeError);

        double TotalLaborIntensity = E95 * 4;
        System.out.printf("Общая трудоемкость проекта = %.2f человеко-часы\n", TotalLaborIntensity);

        double OverallComplexityProject = TotalLaborIntensity / 132;
        System.out.printf("Общая трудоемкость проекта = %.2f человеко-месяцы\n", OverallComplexityProject);

        double OptimalDuration = Math.pow(40, 0.33333333333333) * 2.5;
        System.out.printf("Оптимальная продолжительность проекта = %.2f месяцев\n", OptimalDuration);

        double AveragePopulation = 40 / OptimalDuration;
        System.out.printf("Средняя численность команды = %.0f человек\n", AveragePopulation);
    }
}
