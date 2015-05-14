package essence.task;

public final class Tasks {

	public static Task immediate(Runnable runnable) {
		return () -> {
			runnable.run();
			return true;
		};
	}

	public static Task delayed(int ticks, Runnable runnable) {
		return new TickTask(ticks) {
			@Override
			protected void execute() {
				runnable.run();
				stop();
			}
		};
	}

	public static Task repeated(int ticks, Task task) {
		return new TickTask(ticks) {
			@Override
			protected void execute() {
				if (task.finish())
					stop();
			}
		};
	}

	public static Task continuous(int ticks, Runnable runnable) {
		return repeated(ticks, () -> {
			runnable.run();
			return false;
		});
	}

}
