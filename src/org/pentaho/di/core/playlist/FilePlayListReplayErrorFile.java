/*******************************************************************************
 *
 * Pentaho Data Integration
 *
 * Copyright (C) 2002-2012 by Pentaho : http://www.pentaho.com
 *
 *******************************************************************************
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/

package org.pentaho.di.core.playlist;

import java.io.IOException;

import org.apache.commons.vfs.FileObject;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.trans.step.errorhandling.AbstractFileErrorHandler;


public class FilePlayListReplayErrorFile extends FilePlayListReplayFile {

	private FileObject errorFile;

	public FilePlayListReplayErrorFile(FileObject errorFile, FileObject processingFile) {
		super(processingFile, AbstractFileErrorHandler.NO_PARTS);
		this.errorFile = errorFile;
	}

	public boolean isProcessingNeeded(FileObject file, long lineNr, String filePart)
			throws KettleException {
        try
        {
            return errorFile.exists();
        }
        catch(IOException e)
        {
            throw new KettleException(e);
        }
	}

}
