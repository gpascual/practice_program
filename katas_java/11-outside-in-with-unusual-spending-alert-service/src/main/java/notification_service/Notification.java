package notification_service;

import java.util.Objects;

public class Notification {

  private final User user;
  private final String content;

  public Notification(User user, String content) {

    this.user = user;
    this.content = content;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Notification that = (Notification) o;
    return user.equals(that.user) &&
           content.equals(that.content);
  }

  @Override
  public int hashCode() {
    return Objects.hash(user, content);
  }

  @Override
  public String toString() {
    return "Notification{" +
           "user=" + user +
           ", content='" + content + '\'' +
           '}';
  }
}
