-- Pandoc writer which creates a table of contents file for Eclipse help file.
-- Expects an environment variable HTML_FILEPATH which is the path to the help's HTML file.

local HTML_FILEPATH = os.getenv("HTML_FILEPATH")

-- Character escaping
local function escape(s, in_attribute)
  return s:gsub("[<>&\"']",
    function(x)
      if x == '<' then
        return '&lt;'
      elseif x == '>' then
        return '&gt;'
      elseif x == '&' then
        return '&amp;'
      elseif x == '"' then
        return '&quot;'
      elseif x == "'" then
        return '&#39;'
      else
        return x
      end
    end)
end

-- Table to store footnotes, so they can be included at the end.
local notes = {}
local headers = {}

-- Blocksep is used to separate block elements.
function Blocksep()
	return ""
end

-- This function is called once for the whole document. Parameters:
-- body is a string, metadata is a table, variables is a table.
-- This gives you a fragment.  You could use the metadata table to
-- fill variables in a custom lua template.  Or, pass `--template=...`
-- to pandoc, and pandoc will add do the template processing as
-- usual.
function Doc(body, metadata, variables)
  local buffer = {}
  local function add(s)
    table.insert(buffer, s)
  end
  
  add('<?xml version="1.0" encoding="utf-8"?>\n')
  add('<toc label="' .. metadata['title'] .. '" topic="' .. HTML_FILEPATH .. '">\n')  
  add(get_topic_xml(headers, '\t'))    	
  add(body)
  add('</toc>')

  return table.concat(buffer, '') .. '\n'
end

function get_topic_xml(headers, indention)
  result = ""
  for i=1,table.getn(headers) do
  		header = headers[i]
  		result = result .. indention .. '<topic label="' .. header['label'] .. '" href="' .. HTML_FILEPATH .. '#' .. header.id .. '">\n'  		
  		result = result .. get_topic_xml(header.children, indention .. '\t')
  		result = result .. indention .. '</topic>\n'
  end
  
  return result
end

-- The functions that follow render corresponding pandoc elements.
-- s is always a string, attr is always a table of attributes, and
-- items is always an array of strings (the items in a list).
-- Comments indicate the types of other variables.

-- lev is an integer, the header level.
function Header(lev, s, attr)
	indention = ''
	for i=1,lev do
		indention = indention .. '\t'
	end
	
	new_header = {id = attr['id'], label=s, children={}}
	
	siblings = headers
	
	for i=1,lev-1 do
		last_index = table.getn(siblings)
  		siblings = siblings[last_index].children
  	end
  
	table.insert(siblings, new_header);
	
	return ''--indention .. '<topic label="' .. s .. '" href="' .. HTML_FILEPATH .. '#' .. attr['id'] .. '"/>\n'
end


function Str(s)
  return escape(s)
end

function Space()
	return " "
end

function SoftBreak()
	return ""
end

function LineBreak()
	return ""
end

function Emph(s)
	return ""
end

function Strong(s)
	return ""
end

function Subscript(s)
	return ""
end

function Superscript(s)
	return ""
end

function SmallCaps(s)
	return ""
end

function Strikeout(s)
	return ""
end

function Link(s, src, tit, attr)
	return ""
end

function Image(s, src, tit, attr)
	return ""
end

function Code(s, attr)
	return ""
end

function InlineMath(s)
	return ""
end

function DisplayMath(s)
	return ""
end

function Note(s)
	return ""
end

function Span(s, attr)
	return ""
end

function RawInline(format, str)
	return ""
end

function Cite(s, cs)
	return ""
end

function Plain(s)
	return ""
end

function Para(s)
	return ""
end

function BlockQuote(s)
	return ""
end

function HorizontalRule()
	return ""
end

function CodeBlock(s, attr)
	return ""
end

function BulletList(items)
	return ""
end

function OrderedList(items)
	return ""
end

function CaptionedImage(src, tit, caption, attr)
	return ""
end

-- Caption is a string, aligns is an array of strings,
-- widths is an array of floats, headers is an array of
-- strings, rows is an array of arrays of strings.
function Table(caption, aligns, widths, headers, rows)
	return ""
end

function RawBlock(format, str)
	return ""
end

function Div(s, attr)
	return ""
end

-- The following code will produce runtime warnings when you haven't defined
-- all of the functions you need for the custom writer, so it's useful
-- to include when you're working on a writer.
local meta = {}
meta.__index =
  function(_, key)
    io.stderr:write(string.format("WARNING: Undefined function '%s'\n",key))
    return function() return "" end
  end
setmetatable(_G, meta)

