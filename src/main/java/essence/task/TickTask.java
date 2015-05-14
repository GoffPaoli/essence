package essence.task;

public abstract class TickTask extends AbstractTask {

	private final int ticks;
	private int countdown;

	public TickTask(int ticks) {
		this.ticks = countdown = ticks;
	}

	@Override
	public final boolean finish() {
		if (--countdown < 1) {
			countdown = ticks;
			return super.finish();
		}
		return isRunning();
	}

}
