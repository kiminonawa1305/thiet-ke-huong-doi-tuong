package model;

import java.util.*;

public interface OptionQuestion {
	public Map<String, Boolean> getListAnswer();

	boolean answer(Set<String> answers);
}
