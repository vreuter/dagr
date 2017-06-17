/*
 * The MIT License
 *
 * Copyright (c) 2017 Fulcrum Genomics LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 */

package dagr.core.reporting

import com.fulcrumgenomics.commons.util.{LazyLogging, Logger}
import dagr.core.reporting.ReportingDef.TaskLogger
import dagr.core.tasksystem.Task.{TaskInfo => RootTaskInfo}

/** A simple logger that delegates to [[dagr.core.tasksystem.Task.TaskInfo#logTaskMessage]]. */
class TaskStatusLogger extends TaskLogger {
  // NB: rename this class to set the name on the command line
  private class Dagr extends LazyLogging {
    override lazy val logger: Logger = new Logger(getClass)
  }
  private val logger = new Dagr().logger
  def record(info: RootTaskInfo): Unit = info.logTaskMessage(this.logger)
}