package org.example.pogotrader.data;

import org.springframework.batch.item.ItemProcessor;
import org.example.pogotrader.model.Region;

public class RegionProcessor implements ItemProcessor<RegionInput, Region> {

  @Override
  public Region process(final RegionInput regionInput) throws Exception {

    Region region = new Region();

    region.setId(Integer.parseInt(regionInput.getId()));
    region.setName(regionInput.getName());

    return region;
  }
}
