package org.mockbukkit.mockbukkit.block.state;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.EnchantingTable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Mock implementation of an {@link EnchantingTable}.
 *
 * @see TileStateMock
 */
public class EnchantingTableStateMock extends TileStateMock implements EnchantingTable
{

	private Component customName;

	/**
	 * Constructs a new {@link EnchantingTableStateMock} for the provided {@link Material}.
	 * Only supports {@link Material#ENCHANTING_TABLE}
	 *
	 * @param material The material this state is for.
	 */
	public EnchantingTableStateMock(@NotNull Material material)
	{
		super(material);
		checkType(material, Material.ENCHANTING_TABLE);
	}

	/**
	 * Constructs a new {@link EnchantingTableStateMock} for the provided {@link Block}.
	 * Only supports {@link Material#ENCHANTING_TABLE}
	 *
	 * @param block The block this state is for.
	 */
	protected EnchantingTableStateMock(@NotNull Block block)
	{
		super(block);
		checkType(block, Material.ENCHANTING_TABLE);
	}

	/**
	 * Constructs a new {@link EnchantingTableStateMock} by cloning the data from an existing one.
	 *
	 * @param state The state to clone.
	 */
	protected EnchantingTableStateMock(@NotNull EnchantingTableStateMock state)
	{
		super(state);
		this.customName = state.customName;
	}

	@Override
	public @NotNull BlockState getSnapshot()
	{
		return new EnchantingTableStateMock(this);
	}

	@Override
	public @Nullable Component customName()
	{
		return this.customName;
	}

	@Override
	public void customName(@Nullable Component customName)
	{
		this.customName = customName == null ? Component.text("") : customName;
	}

	@Override
	public @Nullable String getCustomName()
	{
		return LegacyComponentSerializer.legacySection().serialize(this.customName);
	}

	@Override
	public void setCustomName(@Nullable String name)
	{
		this.customName = name == null ? Component.text("") : LegacyComponentSerializer.legacySection().deserialize(name);
	}

}
