package notification_service;

import java.util.Objects;

public class User {

  private final int id;
  private final String mail;

  public User(int id, String mail) {

    this.id = id;
    this.mail = mail;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return id == user.id &&
           Objects.equals(mail, user.mail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, mail);
  }

  @Override
  public String toString() {
    return "User{" +
           "id=" + id +
           ", mail='" + mail + '\'' +
           '}';
  }
}
