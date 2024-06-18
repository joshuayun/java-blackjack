package blackjack.view;

import java.util.List;
import java.util.Scanner;

public class InputView {
    public List<String> inputPlayersName() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        Scanner scanner = new Scanner(System.in);
        String nameString = scanner.nextLine();

        List<String> names = List.of(nameString.trim().split(","));
        return names;
    }


    public boolean inputAdditionalCardCondition(String name) {
        System.out.println(name + "는 한장의 카드를 더 받겠습니까?");
        Scanner scanner = new Scanner(System.in);
        String condition = scanner.nextLine();
        condition = condition.trim();
        return "Y".equals(condition.toUpperCase());
    }



}
