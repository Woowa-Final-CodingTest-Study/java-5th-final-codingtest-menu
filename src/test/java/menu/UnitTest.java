package menu;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import menu.domain.Coach;
import menu.domain.CoachGroup;
import org.junit.jupiter.api.Test;

public class UnitTest {
    @Test
    void 싫어하는_음식_확인_테스트() {
        String name="은지";
        List<String> hateFood= List.of("굴","홍어");

        Coach coach= new Coach(name,hateFood);

        assertThat(coach.isHateFood("굴")).isEqualTo(true);
        assertThat(coach.isHateFood("케이크")).isEqualTo(false);
        assertThat(coach.isHateFood("홍어")).isEqualTo(true);
    }

    @Test
    void 코치중에_싫어하는_음식_있는지_테스트() {
        CoachGroup coachGroup=new CoachGroup();
        coachGroup.addCoach("소리",List.of("짜장면","탕수육"));
        coachGroup.addCoach("미나",List.of("달걀볶음","라자냐"));

        assertThat(coachGroup.isFoodHatersExist("스파게티")).isEqualTo(false);
        assertThat(coachGroup.isFoodHatersExist("달걀볶음")).isEqualTo(true);
        assertThat(coachGroup.isFoodHatersExist("탕수육")).isEqualTo(true);
    }

    @Test
    void 코치중에_싫어하는_음식_있는지_테스트() {
        CoachGroup coachGroup=new CoachGroup();
        coachGroup.addCoach("소리",List.of("짜장면","탕수육"));
        coachGroup.addCoach("미나",List.of("달걀볶음","라자냐"));

        assertThat(coachGroup.isFoodHatersExist("스파게티")).isEqualTo(false);
        assertThat(coachGroup.isFoodHatersExist("달걀볶음")).isEqualTo(true);
        assertThat(coachGroup.isFoodHatersExist("탕수육")).isEqualTo(true);
    }
}
