package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * #207 Course Schedule
 * @author Ryan
 *
 */
public class CourseSchedule {

	boolean res = true;
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		Course[] courses = new Course[numCourses];
		boolean[] visited = new boolean[numCourses];
		boolean[] inStack = new boolean[numCourses];// a node in stack means it
													// is leaf node, no child
													// nodes
		Stack<Course> stack = new Stack<Course>();
		for (int i = 0; i < numCourses; i++)
			courses[i] = new Course(i);
		initGraph(courses, prerequisites);
		for (Course c : courses) {
			if (!inStack[c.n])
				dfs(c, stack, visited, inStack);
		}
		return res;
	}

	private void dfs(Course course, Stack<Course> stack, boolean[] visited, boolean[] inStack) {
		// if a node is visited but not in stack
		// it means this node still has child and it is Ancestor node of itself
		// this must be a cycle
		if (visited[course.n] && !inStack[course.n]){
			res = false;
			return;
		}
		visited[course.n] = true;

		for (Course child : course.children) {
			if (!inStack[child.n])
				dfs(child, stack, visited, inStack);
		}
	
		stack.push(course);
		inStack[course.n] = true;
	}

	private void initGraph(Course[] courses, int[][] prerequisites) {
		for (int[] edge : prerequisites) {
			Course c = courses[edge[1]];
			c.add(courses[edge[0]]);
		}
	}

	class Course {
		int n;
		List<Course> children = new ArrayList<Course>();

		public Course(int n) {
			this.n = n;
		}

		public void add(Course c) {
			children.add(c);
		}
	}

	public static void main(String[] args) {
		CourseSchedule c = new CourseSchedule();
		int[][] prerequisites= {{0,1},{1,0}};
		System.out.print(c.canFinish(2, prerequisites));
	}

}
