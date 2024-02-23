package emailservice.usecases.DTO;

public record EmailResquestDTO(String to, String subject, String body) {

	@Override
	public String toString() {
		return "EmailResquestDTO [to=" + to + ", subject=" + subject + ", body=" + body + "]";
	}

}
