package co.selim.gscrot.jimghost;

import com.redpois0n.gscrot.CaptureUploader;

import gscrot.api.Plugin;

public class JavaImageHostPlugin extends Plugin {

	public JavaImageHostPlugin() {
		super("Java Image Host");
		CaptureUploader.addUploader(new Uploader());
	}

}
