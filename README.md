# BlockBreakers
PaperMC plugin adding machines to help automation. Completely configurable!

# Features
- BlockBreakers ⁠— Automatic miners which break the block below.
- AreaBreakers  ⁠— Like BlockBreakers, but mining 9 blocks instead of 1 below the miner.
## TODO
- StripMiners   — Machines mining straight down and storing everything they mine.
- TunnelMiners  ⁠— Like StripMiners, but mining in the way facing away from the player, mining a 1x2 tunnel and storing all items mined.

# Permissions & Commands
```
`/givebreaker <tier>`
    Receive a block breaker of specified tier 
    Permission: `blockbreakers.breaker.give`
```
```
/giveareabreaker <tier>
    Receive an area breaker of specified tier 
    Permission: `blockbreakers.areabreaker.give`
```
# Configuration
Each type of a breaker is defined seperately in the config.
Currently the plugin is limited to 5 tiers.

```
`breakers` is the root for all the types.
```
```
`block` is for the BlockBreakers.
```
```
`area` is for the AreaBreakers.
```

Each breaker has a configurable:
- `delay`       (time between mining blocks in seconnds),
- `durability`  (amount of times the machine can break blocks),
- `item`        (item the block is broken with)

### Example
Below there will be an example for making a BlockBreaker which would break 1 block per 2 seconds 16 times with the power of a golden pickaxe.

```
breakers:
	block:
		tier1:
			delay: 2
			durability: 16
			item: GOLDEN_PICKAXE
```
This should be enough to allow you to configure the plugin in a way it best fits to your server!
