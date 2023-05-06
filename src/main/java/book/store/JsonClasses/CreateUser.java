package book.store.JsonClasses;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUser {

    public String userName;
    public String password;

}
