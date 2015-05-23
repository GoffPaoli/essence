package essence.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import essence.inject.Inject;

public final class TaskService implements Runnable {

	public static TaskService get(int millis) {
		return new TaskService(millis);
	}

	private final ExecutorService executor = Executors.newWorkStealingPool();
	private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

	private final Queue<Task> tasks = new ConcurrentLinkedQueue<>();

	private final int millis;

	@Inject
	private TaskService(@Tick int millis) {
		this.millis = millis;
	}

	public void submit(Task task) {
		tasks.add(task);
	}

	@Override
	public void run() {
		List<Task> list = new ArrayList<>();
		tasks.removeAll(list);
		for (Task task : tasks) {
			executor.submit(() -> {
				if (!task.finish())
					submit(task);
			});
		}
	}

	public void start() {
		scheduler.scheduleAtFixedRate(this, millis, millis, TimeUnit.MILLISECONDS);
	}

}
