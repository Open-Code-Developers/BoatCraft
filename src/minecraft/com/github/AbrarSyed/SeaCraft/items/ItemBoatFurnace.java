package com.github.AbrarSyed.SeaCraft.items;

import net.minecraft.world.World;

import com.github.AbrarSyed.SeaCraft.boats.EntityBoatBase;
import com.github.AbrarSyed.SeaCraft.boats.EntityBoatFurnace;

public class ItemBoatFurnace extends ItemBoatBase
{
	public ItemBoatFurnace(int par1)
	{
		super(par1);
	}

	@Override
	protected String getNameForTexture()
	{
		return "furnace";
	}

	@Override
	protected EntityBoatBase getBoat(World world)
	{
		return new EntityBoatFurnace(world);
	}
}
