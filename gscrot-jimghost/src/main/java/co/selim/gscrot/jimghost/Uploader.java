package co.selim.gscrot.jimghost;

import com.redpois0n.gscrot.Capture;
import com.redpois0n.gscrot.CaptureUploader;
import com.redpois0n.gscrot.UploadResponse;

import iconlib.IconUtils;

public class Uploader extends CaptureUploader {
	
	public Uploader() {
		super("Java Image Host", IconUtils.getIcon("jimghost", Uploader.class));
	}

	@Override
	public UploadResponse process(Capture capture) throws Exception {
		String response = JavaImageHost.upload(capture.getBinary());
		
		if (response != null) {
			// removal link not supported yet.
			UploadResponse ur = new UploadResponse(response, response);
			ur.setRaw(response);
			
			return ur;
		} else {
			throw new Exception("Error: " + response);
		}
	}

}
