package services;

import repositories.IDb;

public interface ISvcBuilder {
	IDb createDb();
}
