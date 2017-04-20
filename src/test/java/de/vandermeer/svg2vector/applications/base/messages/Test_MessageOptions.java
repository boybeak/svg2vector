/* Copyright 2017 Sven van der Meer <vdmeer.sven@mykolab.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.vandermeer.svg2vector.applications.base.messages;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.vandermeer.execs.options.ExecS_CliParser;
import de.vandermeer.svg2vector.applications.base.Test_Artifacts;

/**
 * Tests for {@link MessageOptions} - message options.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v2.1.0-SNAPSHOT build 170420 (20-Apr-17) for Java 1.8
 * @since      v2.0.0
 */
public class Test_MessageOptions {

	@Test
	public void test_Constructor_Values(){
		MessageOptions mo = new MessageOptions();
		assertEquals(6, mo.getOptions().length);
		assertEquals(MessageOptions.OPTION_ERROR, mo.getMessageMode());
	}

	@Test
	public void test_DefaultMsgOptions(){
		ExecS_CliParser cli = new ExecS_CliParser();
		MessageOptions mo = new MessageOptions();
		cli.addAllOptions(mo.getOptions());
		String[] args = new String[]{};

		assertEquals(null, cli.parse(args));
		assertEquals(0, Test_Artifacts.setCli4Options(cli.getCommandLine(), mo.getOptions()));

		mo.setMessageMode();
		assertEquals(MessageOptions.OPTION_ERROR, mo.getMessageMode());
	}

	@Test
	public void test_WarningMsgOptions(){
		ExecS_CliParser cli = new ExecS_CliParser();
		MessageOptions mo = new MessageOptions();
		cli.addAllOptions(mo.getOptions());
		String[] args = new String[]{
				"-w"
		};

		assertEquals(null, cli.parse(args));
		assertEquals(0, Test_Artifacts.setCli4Options(cli.getCommandLine(), mo.getOptions()));

		mo.setMessageMode();
		assertEquals(MessageOptions.OPTION_ERROR | MessageOptions.OPTION_WARNING, mo.getMessageMode());
	}

	@Test
	public void test_ProgressMsgOptions(){
		ExecS_CliParser cli = new ExecS_CliParser();
		MessageOptions mo = new MessageOptions();
		cli.addAllOptions(mo.getOptions());
		String[] args = new String[]{
				"-p"
		};

		assertEquals(null, cli.parse(args));
		assertEquals(0, Test_Artifacts.setCli4Options(cli.getCommandLine(), mo.getOptions()));

		mo.setMessageMode();
		assertEquals(MessageOptions.OPTION_ERROR | MessageOptions.OPTION_PROGRESS, mo.getMessageMode());
	}

	@Test
	public void test_DetailsMsgOptions(){
		ExecS_CliParser cli = new ExecS_CliParser();
		MessageOptions mo = new MessageOptions();
		cli.addAllOptions(mo.getOptions());
		String[] args = new String[]{
				"-e"
		};

		assertEquals(null, cli.parse(args));
		assertEquals(0, Test_Artifacts.setCli4Options(cli.getCommandLine(), mo.getOptions()));

		mo.setMessageMode();
		assertEquals(MessageOptions.OPTION_ERROR | MessageOptions.OPTION_DEAILS, mo.getMessageMode());
	}

	@Test
	public void test_NoErrors(){
		ExecS_CliParser cli = new ExecS_CliParser();
		MessageOptions mo = new MessageOptions();
		cli.addAllOptions(mo.getOptions());
		String[] args = new String[]{
				"--no-errors"
		};

		assertEquals(null, cli.parse(args));
		assertEquals(0, Test_Artifacts.setCli4Options(cli.getCommandLine(), mo.getOptions()));

		mo.setMessageMode();
		assertEquals(0, mo.getMessageMode());
	}

	@Test
	public void test_VerboseMsgOptions(){
		ExecS_CliParser cli = new ExecS_CliParser();
		MessageOptions mo = new MessageOptions();
		cli.addAllOptions(mo.getOptions());
		String[] args = new String[]{
				"-v"
		};

		assertEquals(null, cli.parse(args));
		assertEquals(0, Test_Artifacts.setCli4Options(cli.getCommandLine(), mo.getOptions()));

		mo.setMessageMode();
		assertEquals(MessageOptions.OPTION_VERBOSE, mo.getMessageMode());
	}

	@Test
	public void test_QuietMsgOptions(){
		ExecS_CliParser cli = new ExecS_CliParser();
		MessageOptions mo = new MessageOptions();
		cli.addAllOptions(mo.getOptions());
		String[] args = new String[]{
				"-q"
		};

		assertEquals(null, cli.parse(args));
		assertEquals(0, Test_Artifacts.setCli4Options(cli.getCommandLine(), mo.getOptions()));

		mo.setMessageMode();
		assertEquals(0, mo.getMessageMode());
	}
}
