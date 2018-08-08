package nice.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "task_id")
    private long id;
    private String taskName;
    private String description;
    private String status;
    private String assignedUser;

    protected Task() {}

   
    
    public Task(String taskName, String description, String status, String assignedUser) {
    	
        this.taskName = taskName;
        this.description = description;
        this.status = status;
        this.assignedUser = assignedUser;
    }

  /*  @Override
    public String toString() {
        return String.format(
                "User[id=%d, userName='%s']",
                id, userName);
    }*/

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

   

    public String getTaskName() {
		return taskName;
	}



	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getAssignedUser() {
		return assignedUser;
	}



	public void setAssignedUser(String assignedUser) {
		this.assignedUser = assignedUser;
	}



	/*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task user = (Task) o;

        if (id != user.id) return false;
        return !(userName != null ? !userName.equals(user.userName) : user.userName != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        return result;
    }*/
}