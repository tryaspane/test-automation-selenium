package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Apps {

    ORANGE_HRM("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    private final String url;

}
