package hard;

import java.util.Arrays;

public class Path {
    private String path;

    public Path(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public Path cd(String newPath) {
    	String currentPath = getPath();
    	String[] path = newPath.split("/");
    	if(path.length == 0) {
    		return new Path("/");
    	}
    	System.out.println("patharray");
    	Arrays.toString(path);
    	String sb = currentPath; 
    	for(int i = 0; i < path.length; i++) {
    		String step = path[i];
    		if(step.equals("")) {
    			sb = "/";
    		} else if(step.equals("..")) {
    			if(sb.length()-2 < 0) {
    				 sb = "/";
    			} else {
    				sb = sb.substring(0, sb.length()-2);
    			}
    		} else {
    			if(sb.equals("/")) {
    				sb += path[i];
    			} else {
    				sb += "/" + path[i];
    			}
    		}
    		System.out.println(i);
    		System.out.println(path[i]);
    		System.out.println(sb);
    	}
    	return new Path(sb);
    }

    public static void main(String[] args) {
    	System.out.println("patharray");
    	Arrays.toString("/".split("/"));
        Path path = new Path("/a/b/c/d");
        System.out.println(path.cd("../../../x/y/z").cd("/").getPath());
    }
}

