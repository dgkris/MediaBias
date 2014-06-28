package batch

import org.apache.hadoop.conf._
import org.apache.hadoop.hbase.HBaseConfiguration
import org.apache.hadoop.hbase.client.{Result, Scan}
import org.apache.hadoop.hbase.filter.{CompareFilter, FilterList, PageFilter, SingleColumnValueFilter}
import org.apache.hadoop.hbase.io.ImmutableBytesWritable
import org.apache.hadoop.hbase.mapreduce.{TableMapReduceUtil, TableMapper, TableReducer}
import org.apache.hadoop.mapreduce._
import org.apache.hadoop.util._


object WordCount extends Configured with Tool {

  class EntityRelationMapper extends TableMapper[ImmutableBytesWritable, Result] {
    def map(row: ImmutableBytesWritable, value: Result, context: Mapper[ImmutableBytesWritable, Result]#Context) {
      Unit
    }
  }

  class EntityRelationReducer extends TableReducer[ImmutableBytesWritable, Result, ImmutableBytesWritable] {
    def reduce(key: ImmutableBytesWritable, values: Iterable[Result],
               context: TableReducer[ImmutableBytesWritable, Result, ImmutableBytesWritable]#Context) {
    }
  }

  def run(args: Array[String]) = {

    var conf = super.getConf()
    var configuration: Configuration = HBaseConfiguration.create()
    var job: Job = new Job(conf, "")

    job setJarByClass classOf[EntityRelationMapper]
    var scan: Scan = new Scan()
    scan.setCacheBlocks(false)
    var filterList: FilterList = new FilterList()
    val filter: SingleColumnValueFilter =
      new SingleColumnValueFilter("TIME".getBytes(), "".getBytes(), CompareFilter.CompareOp.GREATER, "LASTTIME".getBytes())
    var pageFilter: PageFilter = new PageFilter(25)

    filterList.addFilter(filter);
    filterList.addFilter(pageFilter);
    scan.setFilter(filterList);
    scan.setCaching(500);

    TableMapReduceUtil.initTableMapperJob("rawTweetsTable", scan,
      classOf[EntityRelationMapper], classOf[ImmutableBytesWritable], classOf[Result], job)

    TableMapReduceUtil initTableReducerJob("processedTweetsTable", classOf[EntityRelationReducer], job);

    job waitForCompletion (true) match {
      case true => 0
      case false => 1
    }
  }

  def main(args: Array[String]) {
    var c: Configuration = new Configuration()
    var res: Int = ToolRunner.run(c, this, args)
    System.exit(res);
  }

}