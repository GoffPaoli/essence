package essence.task;

public abstract class AbstractTask implements Task {

	private boolean running = true;

	public final boolean isRunning() {
		return running;
	}

	public void stop() {
		if (!running)
			throw new IllegalStateException("Task is already stopped!");
		running = false;
	}

	protected abstract void execute();

	@Override
	public boolean finish() {
		execute();
		return !running;
	}

}
