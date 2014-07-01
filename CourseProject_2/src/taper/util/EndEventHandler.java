package taper.util;

/**
 * A interface used to deal with the End and Error events for writing Asyc Sakai apps.
 * @author we.taper
 *
 * @param <T>
 */
public interface EndEventHandler<T> {
	void finishedWithoutError(T t);
	void errorHappened(Exception e);
}
