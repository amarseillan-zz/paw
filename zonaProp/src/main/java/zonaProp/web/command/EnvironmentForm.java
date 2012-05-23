package zonaProp.web.command;

import zonaProp.model.publication.Environment;
import zonaProp.model.publication.EnvironmentType;

public class EnvironmentForm {

	private int environmentId;
	private EnvironmentType env;
	private String width;
	private String depth;

	public EnvironmentForm() {
	}

	public Environment build() {
		return new Environment(environmentId, env, Integer.valueOf(width),
				Integer.valueOf(depth));
	}

	public EnvironmentType getEnv() {
		return env;
	}

	public void setEnv(EnvironmentType env) {
		this.env = env;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getDepth() {
		return depth;
	}

	public void setDepth(String depth) {
		this.depth = depth;
	}

}
