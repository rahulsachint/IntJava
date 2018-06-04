package ttl.intjava.domain;

public class Student implements Comparable<Student>{

	private int id;
	private String name;
	private Status status;

	public enum Status {
		FULL_TIME, PART_TIME, HIBERNATING
	}

	public Student() {
		super();
	}

	public Student(String name, Status status) {
		super();
		this.name = name;
		this.status = status;
	}

	private Student(int id, String name, Status status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public Status getStatus() {
		return status;
	}

	private void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", status=" + status + "]";
	}

	public static class StudentBuilder {
		private int id = -1;
		private String name;
		private Status status;
		
		public StudentBuilder id(int id) {
			this.id = id;
			return this;
		}
		
		public StudentBuilder name(String name) {
			this.name = name;
			return this;
		}

		public StudentBuilder status(Status status) {
			this.status = status;
			return this;
		}

		public Student build() {
			
			if(id == -1) {
				throw new RuntimeException("Id is required");
					
			}
			return new Student(id, name, status);
		}

	}

	@Override
	public int compareTo(Student other) {
		return this.id - other.id;
	}
}
