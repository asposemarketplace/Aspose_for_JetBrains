/**
* Copyright (c) Aspose 2002-2014. All Rights Reserved.
*
* LICENSE: This program is free software; you can redistribute it 
* and/or modify it under the terms of the GNU General Public License
* as published by the Free Software Foundation; either version 3
* of the License, or (at your option) any later version.
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
* You should have received a copy of the GNU General Public License
* along with this program. If not, 
* see http://opensource.org/licenses/gpl-3.0.html
*
* @author Adeel Ilyas <adeel.ilyas@aspose.com>
*  
*/
package com.aspose.utils;

public class AsposeJavaComponent {
  private String _name;
	private boolean _selected;
	private String _downloadUrl;
	private String _downloadFileName;
	private boolean _downloaded;
	private String _currentVersion;
	private String _latestVersion;
	private boolean _latestRelease;
	private String _changeLog;
	private String _remoteExamplesRepository;
	public AsposeJavaComponent()
	{
		_selected = false;
		_downloaded = false;
		_latestRelease = false;
	}
	/**
	 * @return the _name
	 */
	public String get_name() {
		return _name;
	}

	/**
	 * @param _name the _name to set
	 */
	public void set_name(String _name) {
		this._name = _name;
	}

	/**
	 * @return the _selected
	 */
	public boolean is_selected() {
		return _selected;
	}

	/**
	 * @param _selected the _selected to set
	 */
	public void set_selected(boolean _selected) {
		this._selected = _selected;
	}


	/**
	 * @return the _downloaded
	 */
	public boolean is_downloaded() {
		return _downloaded;
	}

	/**
	 * @param _downloaded the _downloaded to set
	 */
	public void set_downloaded(boolean _downloaded) {
		this._downloaded = _downloaded;
	}

	/**
	 * @return the _currentVersion
	 */
	public String get_currentVersion() {
		return _currentVersion;
	}

	/**
	 * @param _currentVersion the _currentVersion to set
	 */
	public void set_currentVersion(String _currentVersion) {
		this._currentVersion = _currentVersion;
	}

	/**
	 * @return the _downloadUrl
	 */
	public String get_downloadUrl() {
		return _downloadUrl;
	}

	/**
	 * @param _downloadUrl the _downloadUrl to set
	 */
	public void set_downloadUrl(String _downloadUrl) {
		this._downloadUrl = _downloadUrl;
	}

	/**
	 * @return the _latestVersion
	 */
	public String get_latestVersion() {
		return _latestVersion;
	}

	/**
	 * @param _latestVersion the _latestVersion to set
	 */
	public void set_latestVersion(String _latestVersion) {
		this._latestVersion = _latestVersion;
	}

	/**
	 * @return the _latestRelease
	 */
	public boolean is_latestRelease() {
		return _latestRelease;
	}

	/**
	 * @param _latestRelease the _latestRelease to set
	 */
	public void set_latestRelease(boolean _latestRelease) {
		this._latestRelease = _latestRelease;
	}

	/**
	 * @return the _changeLog
	 */
	public String get_changeLog() {
		return _changeLog;
	}

	/**
	 * @param _changeLog the _changeLog to set
	 */
	public void set_changeLog(String _changeLog) {
		this._changeLog = _changeLog;
	}

	/**
	 * @return the _downloadFileName
	 */
	public String get_downloadFileName() {
		return _downloadFileName;
	}

	/**
	 * @param _downloadFileName the _downloadFileName to set
	 */
	public void set_downloadFileName(String _downloadFileName) {
		this._downloadFileName = _downloadFileName;
	}
	public String get_remoteExamplesRepository() {
		return _remoteExamplesRepository;
	}

	/**
	 * 
	 * @param _remoteExamplesRepository
	 */
	public void set_remoteExamplesRepository(String _remoteExamplesRepository) {
		this._remoteExamplesRepository = _remoteExamplesRepository;
	}

  
}
