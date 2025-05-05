package services;

import repositories.IDb;

/**
 * Abstract factory for startup/boot svcs
 */
public interface ISvcBuilder {
	IDb createDb();
	IPersonaService createPersonaService();
}
