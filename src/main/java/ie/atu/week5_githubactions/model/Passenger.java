package ie.atu.week5_githubactions.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Passenger {
    @NotBlank @Size(max = 40)
    private String passengerId;

    @NotBlank @Size(max = 40)
    private String name;

    @NotBlank @Email
    private String email;

    public @NotBlank @Size(max = 40) String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(@NotBlank @Size(max = 40) String passengerId) {
        this.passengerId = passengerId;
    }

    public @NotBlank @Size String getName() {
        return name;
    }

    public void setName(@NotBlank @Size String name) {
        this.name = name;
    }

    public @NotBlank @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank @Email String email) {
        this.email = email;
    }
}
