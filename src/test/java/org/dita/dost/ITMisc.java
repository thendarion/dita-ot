/*
 * This file is part of the DITA Open Toolkit project.
 *
 * Copyright 2016 Jarno Elovirta
 *
 *  See the accompanying LICENSE file for applicable license.
 */

package org.dita.dost;

import static org.dita.dost.AbstractIntegrationTest.Transtype.*;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
interface ITMisc {
  AbstractIntegrationTest builder();

  @Test
  default void testtaskLabel() throws Throwable {
    builder().name("taskLabel").transtype(XHTML).input(Paths.get("map.ditamap")).put("args.gen.task.lbl", "YES").test();
  }

  @Test
  default void testreltableHeaders() throws Throwable {
    builder().name("reltableHeaders").transtype(PREPROCESS).input(Paths.get("reltableheader.ditamap")).test();
  }

  @Test
  default void testreltableTextlink() throws Throwable {
    builder().name("reltableTextlink").transtype(PREPROCESS).input(Paths.get("1132.ditamap")).errorCount(1).test();
  }

  @Test
  default void testlocktitle() throws Throwable {
    builder().name("locktitle").transtype(PREPROCESS).input(Paths.get("TestingLocktitle.ditamap")).test();
  }

  @Test
  default void testchunk_uplevel() throws Throwable {
    builder()
      .name("chunk_uplevel")
      .transtype(PREPROCESS)
      .input(Paths.get("main/chunkup.ditamap"))
      .put("outer.control", "quiet")
      .test();
  }

  @Test
  default void testlink_foreignshortdesc() throws Throwable {
    builder()
      .name("link_foreignshortdesc")
      .transtype(PREPROCESS)
      .input(Paths.get("main.ditamap"))
      .put("validate", "false")
      .warnCount(1)
      .test();
  }

  @Test
  default void testuplevelslink() throws Throwable {
    builder()
      .name("uplevelslink")
      .transtype(PREPROCESS)
      .input(Paths.get("main/uplevel-in-topic.ditamap"))
      .put("outer.control", "quiet")
      .test();
  }

  @Test
  default void testuplevelslinkOnlytopic() throws Throwable {
    builder()
      .name("uplevelslink")
      .transtype(PREPROCESS)
      .input(Paths.get("main/uplevel-in-topic.ditamap"))
      .put("outer.control", "quiet")
      .put("onlytopic.in.map", "true")
      .test();
  }

  @Test
  default void testmappull_topicid() throws Throwable {
    builder()
      .name("mappull-topicid")
      .transtype(PREPROCESS)
      .input(Paths.get("reftopicid.ditamap"))
      .put("validate", "false")
      .warnCount(1)
      .test();
  }

  @Test
  default void testCrawlTopicPreprocess() throws Throwable {
    builder()
      .name("crawl_topic")
      .transtype(PREPROCESS)
      .input(Paths.get("input.ditamap"))
      .put("link-crawl", "topic")
      .test();
  }

  @Test
  default void testCrawlMapPreprocess() throws Throwable {
    builder()
      .name("crawl_map")
      .transtype(PREPROCESS)
      .input(Paths.get("input.ditamap"))
      .put("link-crawl", "map")
      .errorCount(2)
      .warnCount(0)
      .test();
  }

  @Test
  default void resource_map() throws Throwable {
    builder()
      .name("resource_map")
      .transtype(PREPROCESS)
      .input(Paths.get("map.ditamap"))
      .put("args.resources", Paths.get("keys.ditamap"))
      .test();
  }

  @Test
  default void resource_topic() throws Throwable {
    builder()
      .name("resource_topic")
      .transtype(PREPROCESS)
      .input(Paths.get("topic.dita"))
      .put("args.resources", Paths.get("keys.ditamap"))
      .test();
  }

  @Test
  default void testSubjectSchema() throws Throwable {
    builder()
      .name("subjectschema_case")
      .transtype(PREPROCESS)
      .input(Paths.get("simplemap.ditamap"))
      .put("args.filter", Paths.get("filter.ditaval"))
      .test();
  }

  @Test
  default void testlink_parentchild() throws Throwable {
    builder().name("link_parentchild").transtype(XHTML).input(Paths.get("03.ditamap")).test();
  }

  @Test
  default void testlink_xref_extensiontest() throws Throwable {
    builder().name("link_xref_extensiontest").transtype(XHTML).input(Paths.get("test.ditamap")).test();
  }

  @Test
  default void testtitle_includes_markup() throws Throwable {
    builder().name("title_includes_markup").transtype(XHTML).input(Paths.get("test.ditamap")).test();
  }

  @Test
  default void testimage_extension_mixedcase() throws Throwable {
    builder().name("image_extension_mixedcase").transtype(XHTML).input(Paths.get("testpng.ditamap")).test();
  }

  @Test
  default void testcascade_processingrole() throws Throwable {
    builder().name("cascade_processingrole").transtype(XHTML).input(Paths.get("test.ditamap")).test();
  }

  @Test
  default void testimage_scale() throws Throwable {
    builder().name("image-scale").transtype(XHTML).input(Paths.get("test.dita")).test();
  }

  @Test
  default void testlang() throws Throwable {
    builder()
      .name("lang")
      .transtype(XHTML)
      .input(Paths.get("lang.ditamap"))
      .put("validate", "false")
      .warnCount(1)
      .test();
  }

  @Test
  default void testsubjectschema_case() throws Throwable {
    builder()
      .name("subjectschema_case")
      .transtype(XHTML)
      .input(Paths.get("simplemap.ditamap"))
      .put("args.filter", Paths.get("filter.ditaval"))
      .put("clean.temp", "no")
      .test();
  }

  @Test
  default void testfilterlist() throws Throwable {
    final Path testDir = Paths.get("src", "test", "resources", "filterlist", "src");
    final String filters = Stream
      .of(Paths.get("filter1.ditaval"), Paths.get("subdir", "filter2.ditaval"), Paths.get("missing.ditaval"))
      .map(path -> testDir.resolve(path).toAbsolutePath().toString())
      .collect(Collectors.joining(File.pathSeparator));
    builder()
      .name("filterlist")
      .transtype(XHTML)
      .input(Paths.get("simplemap.ditamap"))
      .put("args.filter", filters)
      .put("clean.temp", "no")
      .errorCount(1)
      .test();
  }

  @Test
  default void testuplevels1() throws Throwable {
    builder()
      .name("uplevels1")
      .transtype(XHTML)
      .input(Paths.get("maps/above.ditamap"))
      .put("generate.copy.outer", "1")
      .put("outer.control", "quiet")
      .test();
  }

  @Test
  default void testuplevels3() throws Throwable {
    builder()
      .name("uplevels3")
      .transtype(XHTML)
      .input(Paths.get("maps/above.ditamap"))
      .put("generate.copy.outer", "3")
      .put("outer.control", "quiet")
      .test();
  }
}
